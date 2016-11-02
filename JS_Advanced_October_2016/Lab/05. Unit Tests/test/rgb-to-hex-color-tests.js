let rgbToHexColor = require('../rgb-to-hex-color').rgbToHexColor;

let expect = require("chai").expect;

describe("rgbToHexColor(r, g, b)", function() {

    it("should return #000000 for 0, 0, 0", function() {
        expect(rgbToHexColor(0, 0, 0)).to.be.equal('#000000');
    });
    it("should return #0A0804 for 10, 8, 4", function() {
        expect(rgbToHexColor(10, 8, 4)).to.be.equal('#0A0804');
    });
    it("should return #E5910B for 229, 145, 11", function() {
        expect(rgbToHexColor(229, 145, 11)).to.be.equal('#E5910B');
    });
    it("should return #E5910B for 255, 255, 255", function() {
        expect(rgbToHexColor(255, 255, 255)).to.be.equal('#FFFFFF');
    });
    it("should return undefined for 'pesho', 0, 0", function() {
        expect(rgbToHexColor('pesho', 0, 0)).to.be.equal(undefined);
    });
    it("should return undefined for '-6, 0, 0", function() {
        expect(rgbToHexColor(-6, 0, 0)).to.be.equal(undefined);
    });
    it("should return undefined for '13, 185, 390", function() {
        expect(rgbToHexColor(13, 185, 390)).to.be.equal(undefined);
    });
});