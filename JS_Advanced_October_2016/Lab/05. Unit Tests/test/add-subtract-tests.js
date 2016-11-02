let createCalculator = require("../add-subtract").createCalculator;

let expect = require("chai").expect;
describe("createCalculator()", function() {

    let calc;
    beforeEach(function () {
       calc = createCalculator();
    });

    it("should return 0 after get()", function() {
        expect(calc.get()).to.be.equal(0);
    });

    it("should return 5 after {add 3; add 2}", function() {
        calc.add(3);
        calc.add(2);
        expect(calc.get()).to.be.equal(5);
    });

    it("should return -5 after {subtract 3; subtract 2}", function() {
        calc.subtract(3);
        calc.subtract(2);
        expect(calc.get()).to.be.equal(-5);
    });

    it("should return 0 after {add 3.2; subtract 3.2}", function() {
        calc.add(3.2);
        calc.subtract(3.2);
        expect(calc.get()).to.be.equal(0);
    });

    it("should return 0 after {add 3; subtract 3}", function() {
        calc.add(3);
        calc.subtract(3);
        expect(calc.get()).to.be.equal(0);
    });

    it("should return NaN after {add \"Pesho\"; subtract 3}", function() {
        calc.add("Pesho");
        calc.subtract(3);
        expect(isNaN(calc.get())).to.be.equal(true);
    });

    it("should return NaN after {subtract 'Pesho'}", function() {
        calc.subtract('Pesho');
        expect(isNaN(calc.get())).to.be.equal(true);
    });

    it("should return 0 after {add 1; subtract 1, add -1, subtract -1}", function() {
        calc.add(1);
        calc.subtract(1);
        calc.add('-1');
        calc.subtract('-1');
        expect(calc.get()).to.be.equal(0);
    });
});

