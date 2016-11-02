let mathEnforcer = require("../math-enforcer").mathEnforcer;

let expect = require("chai").expect;
describe("mathEnforcer", function() {
    it("should return undefined after addFive('f')", function() {
        expect(mathEnforcer.addFive('f')).to.be.equal(undefined);
    });

    it("should return undefined after addFive()", function() {
        expect(mathEnforcer.addFive()).to.be.equal(undefined);
    });

    it("should return undefined after addFive(undefined)", function() {
        expect(mathEnforcer.addFive(undefined)).to.be.equal(undefined);
    });

    it("should return undefined after addFive('6')", function() {
        expect(mathEnforcer.addFive('6')).to.be.equal(undefined);
    });

    it("should return 11 after addFive(6)", function() {
        expect(mathEnforcer.addFive(6)).to.be.equal(11);
    });

    it("should return 11 after addFive(-6)", function() {
        expect(mathEnforcer.addFive(-6)).to.be.equal(-1);
    });

    it("should return 11.5 after addFive(6.5)", function() {
        expect(mathEnforcer.addFive(6.5)).to.be.closeTo(11.5, 0.01);
    });

    it("should return -1.5 after addFive(-6.5)", function() {
        expect(mathEnforcer.addFive(-6.5)).to.be.closeTo(-1.5, 0.01);
    });

    it("should return NaN after addFive(NaN)", function() {
        expect(isNaN(mathEnforcer.addFive(NaN))).to.be.equal(true);
    });

    it("should return undefined after subtractTen('f')", function() {
        expect(mathEnforcer.subtractTen('f')).to.be.equal(undefined);
    });

    it("should return NaN after subtractTen(NaN)", function() {
        expect(isNaN(mathEnforcer.subtractTen(NaN))).to.be.equal(true);
    });

    it("should return -10 after subtractTen(0)", function() {
        expect(mathEnforcer.subtractTen(0)).to.be.equal(-10);
    });

    it("should return -15 after subtractTen(-5)", function() {
        expect(mathEnforcer.subtractTen(-5)).to.be.equal(-15);
    });

    it("should return 6.5 after subtractTen(16.5)", function() {
        expect(mathEnforcer.subtractTen(16.5)).to.be.closeTo(6.5, 0.01);
    });

// ==============================
    it("should return undefined after sum('f', 'kur')", function() {
        expect(mathEnforcer.sum('f', 'kur')).to.be.equal(undefined);
    });

    it("should return NaN after sum(NaN, 6)", function() {
        expect(isNaN(mathEnforcer.sum(NaN, 6))).to.be.equal(true);
    });

    it("should return NaN after sum(6, NaN)", function() {
        expect(isNaN(mathEnforcer.sum(6, NaN))).to.be.equal(true);
    });

    it("should return NaN after sum(NaN, NaN)", function() {
        expect(isNaN(mathEnforcer.sum(NaN, NaN))).to.be.equal(true);
    });

    it("should return undefined after sum('f', 6)", function() {
        expect(mathEnforcer.sum('f', 6)).to.be.equal(undefined);
    });

    it("should return undefined after sum(6, 'kur')", function() {
        expect(mathEnforcer.sum(6, 'kur')).to.be.equal(undefined);
    });

    it("should return 12 after sum(6, 6)", function() {
        expect(mathEnforcer.sum(6, 6)).to.be.equal(12);
    });

    it("should return -12 after sum(-6, -6)", function() {
        expect(mathEnforcer.sum(-6, -6)).to.be.equal(-12);
    });

    it("should return 13 after sum(6.5, 6.5)", function() {
        expect(mathEnforcer.sum(6.5, 6.5)).to.be.closeTo(13, 0.01);
    });

    it("should return 0 after sum(6.5, -6.5)", function() {
        expect(mathEnforcer.sum(6.5, -6.5)).to.be.closeTo(0, 0.01);
    });
});

