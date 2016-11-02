class SortedList{
    constructor(){
        this.sortedList =[];
        this.size = 0;
    }

    add(element){
        element = Number(element);
        if (typeof element === 'number'){
            this.sortedList.push(element);
            this.size++;
            this.sortedList.sort((a, b) => a - b);
        }
    }

    remove(index){
        index = Number(index);
        if (index >= 0 && index < this.size){
            for (let i = index; i < this.size - 1; i++){
                this.sortedList[i] = this.sortedList[i + 1];
            }
            this.size--;
            return true;
        }
        else{
            throw "Error: Index out of range";
        }
    }

    get(index){
        index = Number(index);
        if (typeof index === 'number'){
            if (index >= 0 || index < this.size){
                return this.sortedList[index];
            }
            throw "Error: Index out of range";
        }
    }
}

let newList = new SortedList();
newList.add(5);
console.log(newList.get(0));