function createComputerHierarchy() {



    class Product{
        constructor(manufacturer){
            if (new.target === Product){
                throw new Error ("Abstract class cannot be instantiated directly");
            }
            this.manufacturer = manufacturer;
        }

        validInstance(obj, constructor) {
        if (obj instanceof constructor){
            return obj;
        }
        throw new TypeError(`${obj} is not an instance of required class.`);
    }
    }

    class Keyboard extends Product{
        constructor(manufacturer, responseTime){
            super(manufacturer);
            this.responseTime = Number(responseTime);
        }
    }

    class Monitor extends Product{
        constructor(manufacturer, width, height){
            super(manufacturer);
            this.width = Number(width);
            this.height = Number(height);
        }
    }

    class Battery extends Product{
        constructor(manufacturer, expectedLife){
            super(manufacturer);
            this.expectedLife = Number(expectedLife);
        }
    }

    class Computer extends Product{
        constructor(manufacturer, processorSpeed_Ghz, ram_Gb, hardDiskSpace_Tb){
            if (new.target === Computer){
                throw new Error("Abstract class cannot be instantiated directly");
            }
            super(manufacturer);
            this.processorSpeed_Ghz = Number(processorSpeed_Ghz);
            this.ram_Gb = Number(ram_Gb);
            this.hardDiskSpace_Tb = Number(hardDiskSpace_Tb);
        }
    }

    class Laptop extends Computer{
        constructor(manufacturer, processorSpeed_Ghz, ram_Gb, hardDiskSpace_Tb,weight, color, battery){
            super(manufacturer, processorSpeed_Ghz, ram_Gb, hardDiskSpace_Tb);
            this.weight = Number(weight);
            this.color = color;
            this._battery = this.validInstance(battery, Battery);
        }

        get battery(){
            return this._battery;
        }

        set battery(battery){
            this._battery = this.validInstance(battery, Battery);
        }
    }

    class Desktop extends Computer{
        constructor(manufacturer, processorSpeed_Ghz, ram_Gb, hardDiskSpace_Tb,keyboard, monitor){
            super(manufacturer, processorSpeed_Ghz, ram_Gb, hardDiskSpace_Tb);
            this._keyboard = this.validInstance(keyboard, Keyboard);
            this._monitor = this.validInstance(monitor, Monitor);
        }

        get keyboard(){
            return this._keyboard;
        }

        set keyboard(keyboard){
            this._keyboard = this.validInstance(keyboard, Keyboard);
        }

        get monitor(){
            return this._monitor;
        }

        set monitor(monitor){
            this._monitor = this.validInstance(monitor, Monitor);
        }

    }

    return {
        Product,
        Battery,
        Keyboard,
        Monitor,
        Computer,
        Laptop,
        Desktop
    }
}

function createMixins() {
    function computerQualityMixin(classToExtend) {
        function attach() {
            this.getQuality = function () {
                return (this.processorSpeed_Ghz + this.ram_Gb + this.hardDiskSpace_Tb) / 3;
            };

            this.isFast = function () {
                return this.processorSpeed_Ghz > (this.ram_Gb / 4);
            };

            this.isRoomy = function () {
                return this.hardDiskSpace_Tb > Math.floor(this.ram_Gb * this.processorSpeed_Ghz);
            };
        }
        attach.call(classToExtend.prototype);
    }

    function styleMixin(classToExtend) {
        function attach() {
            this.isFullSet = function () {
                return this._keyboard.manufacturer === this._monitor.manufacturer;
            };

            this.isClassy = function () {
                let batteryLifeCondition = this._battery.expectedLife >= 3;
                let colorCondition = ["Silver", "Black"].includes(this.color);
                let weightConition = this.weight < 3;

                return batteryLifeCondition && colorCondition && weightConition;
            }
        }

        attach.call(classToExtend.prototype);
    }

    return{
        computerQualityMixin,
        styleMixin
    }
}

let classes = createComputerHierarchy();

let Computer = classes.Computer;
let Laptop = classes.Laptop;
let Desktop = classes.Desktop;
let Monitor = classes.Monitor;
let Battery = classes.Battery;
let Keyboard = classes.Keyboard;

let keyboard = new Keyboard('Logitech',70);
let monitor = new Monitor('Benq',28,18);
let desktop = new Desktop("JAR Computers",3.3,8,1,keyboard,monitor);

computerQualityMixin.call(Desktop.prototype);

console.log(desktop.getQuality());
console.log(desktop.isFast());
console.log(desktop.isRoomy());