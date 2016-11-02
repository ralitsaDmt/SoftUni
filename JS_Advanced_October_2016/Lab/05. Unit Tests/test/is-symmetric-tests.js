let isSymmetric = require("../is-symmetric").isSymmetric;

let expect = require("chai").expect;
describe("sum(arr)", function() {
    it("should return false for ''", function() {
        expect(isSymmetric('')).to.be.equal(false);
    });
    it("should return true for [NaN, NaN, NaN, NaN]", function() {
        expect(isSymmetric([NaN, NaN, NaN, NaN])).to.be.equal(true);
    });
    it("should return true for []", function() {
        expect(isSymmetric([])).to.be.equal(true);
    });
    it("should return false for [1, 2, 2]", function() {
        expect(isSymmetric([1, 2, 2])).to.be.equal(false);
    });
    it("should return true for [1, 2, 2, 1]", function() {
        expect(isSymmetric([1, 2, 2, 1])).to.be.equal(true);
    });
    it("should return true for ['pesho']", function() {
        expect(isSymmetric(['pesho'])).to.be.equal(true);
    });
    it("should return true for ['foo', 'i', 'foo']", function() {
        expect(isSymmetric(['foo', 'i', 'foo'])).to.be.equal(true);
    });
    it("should return false for ['foo', 'i', 'meh']", function() {
        expect(isSymmetric(['foo', 'i', 'meh'])).to.be.equal(false);
    });
});

