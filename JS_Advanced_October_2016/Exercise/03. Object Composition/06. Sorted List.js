function solve() {

    function SortedList() {
        let list = [];
        return list;
    }

    let newList = new SortedList();

    newList.size = 0;

    newList.add = function (num) {
        let list = this;
        list.push(num);
        list.size++;
        return list.sort((a, b) => a - b);
    };

    newList.remove = function (index) {
        if (index >= 0 && index < this.size){
            for (let i = index; i < this.size - 1; i++){
                this[i] = this[i + 1];
            }
            this.size--;
            return true;
        }
        else{
            throw "Error";
        }
    };

    newList.get = function (index) {
        if (index < 0 || index >= this.size){
            throw "Error";
        }
        return this[index];
    };

    return newList;
}

let list = new solve();
list.add(1);
list.add(-1);
list.remove(0);
console.log(list[0]);
