let Console = require("../console");

let expect = require("chai").expect;

describe("Console", function () {

    it("should have method writeLine()", function () {
        expect(Console.hasOwnProperty('writeLine'))
            .to.equal(true, "Method writeLine() not found.");
    });

    it("should return 'string' with writeLine('string')", function () {
        expect(Console.writeLine('string'))
            .to.equal('string', false);
    });

    it("with object, should return JSON representation of the object", function () {
        expect(Console.writeLine({name: 'Pesho'}))
            .to.equal('{"name":"Pesho"}');
    });

    it("with object, should return JSON representation of the object", function () {
        expect(Console.writeLine({age: 23}))
            .to.equal('{"age":23}');
    });

    it("with invalid template string and parameters", function () {
        expect(() => Console.writeLine(1, "Roli"))
            .to.throw(TypeError,"No string format given!");
    });

    it("with template string and invalid count of parameters", function () {
        expect(() => Console.writeLine("Template {0}, {1}, {2}", '0', '1'))
            .to.throw(RangeError,"Incorrect amount of parameters given!");
    });

    it("with template string with invalid placeholder indexes and valid count of parameters", function () {
        expect(() => Console.writeLine("Template {0}, {1}, {12}", '0', '1', '2'))
            .to.throw(RangeError, "Incorrect placeholders given!");
    });

    it("with valid template string and valid count of parameters", function () {
        expect(Console.writeLine("Template {0}, {1}, {2}", '0', '1', '2'))
            .to.equal("Template 0, 1, 2");
    });
});