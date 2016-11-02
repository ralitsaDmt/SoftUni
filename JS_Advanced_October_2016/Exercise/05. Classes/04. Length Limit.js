class Stringer{
    constructor(str, len){
        this.str = str;
        this.len = len;
    }

    get innerString(){
        return this.str.toString();
    }

    get innerLength(){
        return this.len;
    }

    increase(length){
        this.len += length;
    }

    decrease(length){
        this.len -= length;
        if (this.len < 3){
            this.len = 0;
        }
    }

    toString(){
        if (this.len === 0){
            return '...';
        }

        if (this.str.length <= this.len){
            return this.str;
        }

        return this.str.substr(0, this.len) + '...';
    }
}