let isOddOrEven = require("../even-or-odd").isOddOrEven;

let expect = require("chai").expect;
describe("isOddOrEven()", function() {

    it("should return undefined after 6", function() {
        expect(isOddOrEven(6)).to.be.equal(undefined);
    });

    it("should return undefined after NaN", function() {
        expect(isOddOrEven(NaN)).to.be.equal(undefined);
    });

    it("should return undefined after undefined", function() {
        expect(isOddOrEven(undefined)).to.be.equal(undefined);
    });

    it("should return odd after mocha", function() {
        expect(isOddOrEven("mocha")).to.be.equal("odd");
    });

    it("should return even after chai", function() {
        expect(isOddOrEven("chai")).to.be.equal("even");
    });
});

