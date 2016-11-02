let sum = require("../sum-array").sum;

let expect = require("chai").expect;
describe("sum(arr)", function() {
    it("should return 3 for [1, 2]", function() {
        expect(sum([1, 2])).to.be.equal(3);
    });
    it("should return 1 for [1]", function() {
        expect(sum([1])).to.be.equal(1);
    });
    it("should return 0 for []", function() {
        expect(sum([])).to.be.equal(0);
    });
    it("should return 4 for [1.4, 1.3, 1.3]", function() {
        expect(sum([1.4, 1.3, 1.3])).to.be.equal(4);
    });
    it("should return -8 for [-2, -1, -5]", function() {
        expect(sum([-2, -1, -5])).to.be.equal(-8);
    });
    it("should return NaN for [\"pesho\"]", function() {
        expect(isNaN(sum(["pesho"]))).to.be.equal(true);
    });
});


console.log(sum([2, 4]));