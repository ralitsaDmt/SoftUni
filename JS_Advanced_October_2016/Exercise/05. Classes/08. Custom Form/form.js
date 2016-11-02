let result = (function () {
    class Textbox {
        constructor(selector, regex){
            this.selector = selector;
            this._elements = $(selector);
            this._invalidSymbols = regex;

            let that = this;
            $(selector).on('input change', function () {
                that.value = $(this).val();
            })
        }

        get value(){
            return $(this.selector).val();
        }

        set value(value){
            $(this.selector).val(value);
        }

        get elements(){
            return this._elements;
        }

        isValid(){
            return !(this._invalidSymbols.test($(this.selector).val()));
        }
    }


    class Form{
        constructor(...textBoxElements){
            for (let textBox of textBoxElements){
                if (!textBox instanceof Textbox){
                    throw new Error('Argument is not instance of class Textbox');
                }
            }

            this._textboxes = textBoxElements;
            this._element = $('<div>').addClass('form');
            for (let textBox of textBoxElements){
                this._element.append($(textBox.selector));
            }
        }

        submit(){
            let allValid = true;
            for (let textBox of this._textboxes){
                if (textBox.isValid()){
                    $(textBox.selector).css('border', '2px solid green');
                }
                else{
                    $(textBox.selector).css('border', '2px solid red');
                    allValid = false;
                }
            }
            return allValid;
        }

        attach(selector){
            $(selector).append(this._element);
        }
    }

    return{
        Textbox: Textbox,
        Form: Form
    }
})();

let Textbox = result.Textbox;
let Form = result.Form;
let username = new Textbox('#username', /[^a-zA-Z0-9]/);
let password = new Textbox('#password', /^a-zA-Z/);
username.value = "username";
password.value = "password";
let form = new Form(username, password);
form.attach("#root");
form.submit();