import { Employee } from './employee';

// let Employee = require('./employee');

export class Branch{
    constructor(id, branchName, companyName){
        this.id = Number(id);
        this.branchName = branchName;
        this.companyName = companyName;
        this._employees = [];
    }

    get employees(){
        return this._employees;
    }

    hire(employee){
        this._employees.push(employee);
    }

    toString(){
        let strToPrint = `@ ${this.companyName}, ${this.branchName}, ${this.id}\n`;
        strToPrint += `Employed:\n`;

        if (this._employees.length !== 0){
            strToPrint += `** ${this._employees.join('\n** ')}`;
        }
        else{
            strToPrint += 'None';
        }

        return strToPrint;
    }
}
//
// let branch = new Branch(1, "BabelCompany", "BabelBranch");
//
// console.log(branch.toString());

// module.exports = Branch;