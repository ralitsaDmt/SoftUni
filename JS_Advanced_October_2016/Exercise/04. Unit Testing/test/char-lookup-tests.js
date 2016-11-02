let lookupChar = require("../char-lookup").lookupChar;

let expect = require("chai").expect;
describe("lookupChar()", function() {

    it("should return undefined after 6, 6", function() {
        expect(lookupChar(6, 6)).to.be.equal(undefined);
    });

    it("should return undefined after 'mocha', '6'", function() {
        expect(lookupChar("mocha", "6")).to.be.equal(undefined);
    });

    it("should return undefined after 'mocha', 6.2", function() {
        expect(lookupChar("mocha", 6.2)).to.be.equal(undefined);
    });

    it("should return 'Incorrect index' after 'mocha', 6", function() {
        expect(lookupChar("mocha", 6)).to.be.equal('Incorrect index');
    });

    it("should return 'Incorrect index' after 'mocha', -5", function() {
        expect(lookupChar("mocha", -5)).to.be.equal('Incorrect index');
    });

    it("should return 'c' after 'mocha', 2", function() {
        expect(lookupChar("mocha", 2)).to.be.equal('c');
    });

});

