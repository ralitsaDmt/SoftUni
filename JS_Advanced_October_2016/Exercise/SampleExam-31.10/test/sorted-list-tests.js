let expect = require("chai").expect;

class SortedList {
    constructor() {
        this.list = [];
    }

    add(element) {
        this.list.push(element);
        this.sort();
    }

    remove(index) {
        this.vrfyRange(index);
        this.list.splice(index, 1);
    }

    get(index) {
        this.vrfyRange(index);
        return this.list[index];
    }

    vrfyRange(index) {
        if (this.list.length == 0) throw new Error("Collection is empty.");
        if (index < 0 || index >= this.list.length) throw new Error("Index was outside the bounds of the collection.");
    }

    sort() {
        this.list.sort((a, b) => a - b);
    }

    get size() {
        return this.list.length;
    }
}

describe("SortedList", function() {

    let list;
    beforeEach(function () {
        list = new SortedList();
    });

    it("should have a constructor", function () {
        expect(typeof SortedList).to.equal('function');

        expect(SortedList.prototype.hasOwnProperty('add'))
            .to.equal(true, "Didn't find 'add' function");
        expect(SortedList.prototype.hasOwnProperty('remove'))
            .to.equal(true, "Didn't find 'remove' function");
        expect(SortedList.prototype.hasOwnProperty('get'))
            .to.equal(true, "Didn't find 'get' function");
        expect(SortedList.prototype.hasOwnProperty('size'))
            .to.equal(true, "Didn't find 'size' property");
    });

    it("size should be 0 for empty list", function () {
        expect(list.size).to.equal(0);
    });

    it("should have working 'add' function", function() {
        list.add(5);
        expect(list.size).to.equal(1);
    });

    it("should have working 'add' and 'get' functions", function() {
        list.add(5);
        expect(list.get(0)).to.equal(5);
    });

    it("should be sorted", function() {
        list.add(5);
        list.add(3);
        list.add(18);
        list.add(1);

        expect(list.get(0)).to.equal(1);
        expect(list.get(1)).to.equal(3);
        expect(list.get(2)).to.equal(5);
        expect(list.get(3)).to.equal(18);
        expect(list.size).to.equal(4);
    });

    it("should have working 'remove' function", function() {
        list.add(5);
        list.add(3);
        list.add(18);
        list.add(1);
        list.remove(2);
        expect(list.get(0)).to.equal(1);
        expect(list.get(1)).to.equal(3);
        expect(list.get(2)).to.equal(18);
        expect(list.size).to.equal(3);
    });

    it("should not work with negative index", function() {
        list.add(5);
        list.add(3);
        expect(() => list.get(-1)).to.throw(Error);
        expect(() => list.remove(-1)).to.throw(Error);
    });

    it("should not work with outside index", function() {
        list.add(5);
        list.add(3);
        expect(() => list.get(4)).to.throw(Error);
        expect(() => list.remove(4)).to.throw(Error);
    });

    it("should not work with empty collection", function() {
        expect(() => list.get(0)).to.throw(Error);
        expect(() => list.remove(0)).to.throw(Error);
    });
});
