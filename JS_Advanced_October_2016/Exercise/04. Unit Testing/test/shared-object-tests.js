
let expect = require("chai").expect;
let jsdom = require("jsdom-global")();
let $ = require("jquery");

document.body.innerHTML = `<div id="wrapper">
                               <input type="text" id="name">
                               <input type="text" id="income">
                           </div>`;

let sharedObject = {
    name: null,
    income: null,
    changeName: function (name) {
        if (name.length === 0) {
            return;
        }
        this.name = name;
        let newName = $('#name');
        newName.val(this.name);
    },
    changeIncome: function (income) {
        if (!Number.isInteger(income) || income <= 0) {
            return;
        }
        this.income = income;
        let newIncome = $('#income');
        newIncome.val(this.income);
    },
    updateName: function () {
        let newName = $('#name').val();
        if (newName.length === 0) {
            return;
        }
        this.name = newName;
    },
    updateIncome: function () {
        let newIncome = $('#income').val();
        if (isNaN(newIncome) || !Number.isInteger(Number(newIncome)) || Number(newIncome) <= 0) {
            return;
        }
        this.income = Number(newIncome);
    }
};

describe("DOM testing", function() {

    it("Initial value for name should be null", function() {
        expect(sharedObject.name).to.be.equal(null, "Name did not start with value null");
    });

    it("Initial value for income should be null", function() {
        expect(sharedObject.income).to.be.equal(null, "Income did not start with value null");
    });

    describe("changeName()", function () {
        it("check for invalid parameters, should not change property", function () {
            sharedObject.changeName("");
            expect(sharedObject.name).to.be.equal(null, "Name changed incorrectly");
        });

        it("check for invalid parameters and preexisting name value, should not change property", function () {
            sharedObject.name = 'Roli';
            sharedObject.changeName("");
            expect(sharedObject.name).to.be.equal('Roli', "Name changed incorrectly");
        });

        it("check for valid name, should change name property", function () {
            sharedObject.changeName("pesho");
            expect(sharedObject.name).to.be.equal("pesho", "Name did not change");
        });

        it("check for valid name, should change name textbox value", function () {
            sharedObject.changeName('John');
            let nameTextBox = $('#name');
            expect(nameTextBox.val()).to.be.equal('John', "Textbox value did not change");
        });

        it("check for invalid parameters, should not change name textbox value", function () {
            let nameTextBox = $('#name');
            nameTextBox.val('Mochi');
            sharedObject.changeName('');
            expect(nameTextBox.val()).to.be.equal('Mochi', "Textbox value changed incorrectly");
        });
    });

    describe("changeIncome()", function () {

        it("check for {name: 'pesho'}, should not change income property", function () {
            sharedObject.income = 1300;
            sharedObject.changeIncome({name:'pesho'});
            expect(sharedObject.income).to.be.equal(1300, "Income changed incorrectly");
        });

        it("check for invalid parameters and preexisting income value, should not change property", function () {
            let oldValue = sharedObject.income;
            sharedObject.changeIncome("");
            expect(sharedObject.income).to.be.equal(oldValue, "Income changed incorrectly");
        });

        it("check for floating point number, should not change property", function () {
            sharedObject.income = 1300;
            sharedObject.changeIncome(1000.25);
            expect(sharedObject.income).to.be.equal(1300, "Income changed incorrectly");
        });

        it("check for negative integer, should not change income property", function () {
            sharedObject.income = 1300;
            sharedObject.changeIncome(-3000);
            expect(sharedObject.income).to.be.equal(1300, "Income changed incorrectly");
        });

        it("check for 0, should not change income property", function () {
            sharedObject.income = 1300;
            sharedObject.changeIncome(0);
            expect(sharedObject.income).to.be.equal(1300, "Income changed incorrectly");
        });

        it("check for positive integer, should change income property", function () {
            sharedObject.income = 2000;
            sharedObject.changeIncome(3000);
            expect(sharedObject.income).to.be.equal(3000, "Income text box value did not change");
        });

        // Tests for textbox income
        it("check for {name: 'pesho'}, should not change income textbox value", function () {
            let incomeTextBox = $('#income');
            incomeTextBox.val('1000');
            sharedObject.changeIncome({name: 'pesho'});
            expect(incomeTextBox.val()).to.be.equal('1000', "Income changed incorrectly");
        });

        it("check for empty string, should not change income text box value", function () {
            let incomeTextBox = $('#income');
            incomeTextBox.val('1000');
            sharedObject.changeIncome('');
            expect(incomeTextBox.val()).to.be.equal('1000', "Income changed incorrectly");
        });

        it("check for floating point integer, should not change income text box value", function () {
            let incomeTextBox = $('#income');
            incomeTextBox.val('1000');
            sharedObject.changeIncome(236.52);
            expect(incomeTextBox.val()).to.be.equal('1000', "Income changed incorrectly");
        });

        it("check for negative integer, should not change income text box value", function () {
            let incomeTextBox = $('#income');
            incomeTextBox.val('1000');
            sharedObject.changeIncome(-3000);
            expect(incomeTextBox.val()).to.be.equal('1000', "Income changed incorrectly");
        });

        it("check for 0, should not change income text box value", function () {
            let incomeTextBox = $('#income');
            incomeTextBox.val('1000');
            sharedObject.changeIncome(0);
            expect(incomeTextBox.val()).to.be.equal('1000', "Income changed incorrectly");
        });

        it("check for positive integer, should change income text box value", function () {
            let incomeTextBox = $('#income');
            incomeTextBox.val('1000');
            sharedObject.changeIncome(2000);
            expect(incomeTextBox.val()).to.be.equal('2000', "Income text box value did not change");
        });
    });

    describe("updateName()", function () {
        it("with empty string, should not change name", function () {
            sharedObject.name = 'test';
            let nameTextBox = $('#name');
            nameTextBox.val('');
            sharedObject.updateName();
            expect(sharedObject.name).to.be.equal('test', "Name changed incorrectly");
        });

        it("with invalid parameter, should not change name", function () {
            sharedObject.name = 'test';
            let nameTextBox = $('#name');
            nameTextBox.val([1, 2, 3]);
            sharedObject.updateName();
            expect(sharedObject.name).to.be.equal('test', "Name changed incorrectly");
        });

        it("with valid parameter, should not change name", function () {
            sharedObject.name = 'test';
            let nameTextBox = $('#name');
            nameTextBox.val('Roli');
            sharedObject.updateName();
            expect(sharedObject.name).to.be.equal('Roli', "Name changed incorrectly");
        });
    });

    describe("updateIncome()", function () {
        it("with empty string, should not change income proert", function () {
            sharedObject.income = 2000;
            let incomeTextBox = $('#income');
            incomeTextBox.val('');
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(2000, "Income changed incorrectly");
        });

        it("with invalid parameter, should not change income property", function () {
            sharedObject.income = 2000;
            let incomeTextBox = $('#income');
            incomeTextBox.val({stop: 'stop'});
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(2000, "Income changed incorrectly");
        });

        it("with negative integer, should not change income property", function () {
            sharedObject.income = 2000;
            let incomeTextBox = $('#income');
            incomeTextBox.val(-2000);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(2000, "Income changed incorrectly");
        });

        it("with negative integer, should not change income property", function () {
            sharedObject.income = 2000;
            let incomeTextBox = $('#income');
            incomeTextBox.val(-2000);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(2000, "Income changed incorrectly");
        });

        it("with floating point number, should not change income property", function () {
            sharedObject.income = 2000;
            let incomeTextBox = $('#income');
            incomeTextBox.val(625.50);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(2000, "Income changed incorrectly");
        });

        it("with 0, should not change income property", function () {
            sharedObject.income = 2000;
            let incomeTextBox = $('#income');
            incomeTextBox.val(0);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(2000, "Income changed incorrectly");
        });

        it("with valid positive integer, should not change income property", function () {
            sharedObject.income = 2000;
            let incomeTextBox = $('#income');
            incomeTextBox.val(3000);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(3000, "Income changed incorrectly");
        });
    });

});