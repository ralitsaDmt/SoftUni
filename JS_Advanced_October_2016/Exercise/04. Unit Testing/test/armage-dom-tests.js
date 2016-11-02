let expect = require("chai").expect;
let jsdom = require("jsdom-global")();
let $ = require("jquery");

function nuke(selector1, selector2) {
    if (selector1 === selector2) return;
    $(selector1).filter(selector2).remove();
}

describe("nuke()", function() {
    beforeEach(function () {
        document.body.innerHTML = `<div id="target">
    <div class="nested target">
        <p>This is some text</p>
    </div>
    <div class="target">
        <p>Empty div</p>
    </div>
    <div class="inside">
        <span class="nested">Some more text</span>
        <span class="target">Some more text</span>
    </div>
</div>
`;
    });

    it("with invalid first selector, should change nothing", function() {
        let selector = '#target';
        //let unchangedHtml = $(selector).html();
        let lenBefore = $(selector).length;
        nuke('p', '#target');
        //let changedHtml = $(selector).html();
        let lenAfter = $(selector).length;
        expect(lenBefore).to.be.equal(lenAfter, "HTML changed incorrectly");
    });

    it("with invalid second selector, should change nothing", function() {
        let selector = '#target';
        let unchangedHtml = $(selector).html();
        nuke('#target', 8);
        let changedHtml = $(selector).html();
        expect(changedHtml).to.be.equal(unchangedHtml, "HTML changed incorrectly");
    });

    it("with valid parameters, but first is omitted, should change nothing", function() {
        let selector1 = '#target';
        let selector2 = 'p';
        let unchangedHtml = $(selector1).html();
        nuke(selector1, selector2);
        let changedHtml = $(selector1).html();
        expect(changedHtml).to.be.equal(unchangedHtml, "HTML changed incorrectly");
    });

    it("with valid parameters, but second parameter is omitted, should change nothing", function() {
        let selector1 = '#target';
        let selector2 = 'p';
        let unchangedHtml = $(selector2).html();
        nuke(selector2, selector1);
        let changedHtml = $(selector2).html();
        expect(changedHtml).to.be.equal(unchangedHtml, "HTML changed incorrectly");
    });

    it("with valid parameters, which are the same, should change nothing", function() {
        let selector = '#target';
        let unchangedHtml = $(selector).html();
        nuke('#target', '#target');
        let changedHtml = $(selector).html();
        expect(changedHtml).to.be.equal(unchangedHtml, "HTML changed incorrectly");
    });

    it("with valid parameters, should change HTML", function() {
        let selector1 = '.target';
        let selector2 = '.nested';
        nuke(selector1, selector2);
        let changedHtmlLenght = $(selector1 + selector2).length;
        expect(changedHtmlLenght).to.be.equal(0, "HTML changed incorrectly");
    });

});

