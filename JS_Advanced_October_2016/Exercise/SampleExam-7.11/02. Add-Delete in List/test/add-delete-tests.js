var expect = require('chai').expect;

let list = (function(){
    let data = [];
    return {
        add: function(item) {
            data.push(item);
        },
        delete: function(index) {
            if (Number.isInteger(index) && index >= 0 && index < data.length) {
                return data.splice(index, 1)[0];
            } else {
                return undefined;
            }
        },
        toString: function() {
            return data.join(", ");
        }
    };
})();

describe("list", function () {


    it("should have property add", function () {
        expect(list.hasOwnProperty('add')).to.equal(true);
    });

    it("should have property delete", function () {
        expect(list.hasOwnProperty('delete')).to.equal(true);
    });

    it("should have property toString", function () {
        expect(list.hasOwnProperty('toString')).to.equal(true);
    });

    it("should add elements", function () {
        list.add(1);
        list.add(2);
        expect(list.toString()).to.equal('1, 2');
    });

    it("should add elements", function () {
        list.add('foo');
        list.add('bar');
        list.add('foo');
        expect(list.toString()).to.equal('foo, bar, foo');
        expect(list.delete(1)).to.equal('bar');
        expect(list.toString()).to.equal('foo, foo');
    });

    it("should remove element", function () {
        expect(list.toString()).to.equal('');
    });

    it("should remove element", function () {
        list.add(1);
        list.add(2);
        list.add(3);
        expect(list.delete(0)).to.equal('1');
        expect(list.toString()).to.equal('2, 3');
    });

    it("should remove element", function () {
        list.add(1);
        expect(list.delete(8)).to.equal('undefined');
    });

    it("should remove element", function () {
        list.add(1);
        expect(list.delete(-5)).to.equal('undefined');
    });
});