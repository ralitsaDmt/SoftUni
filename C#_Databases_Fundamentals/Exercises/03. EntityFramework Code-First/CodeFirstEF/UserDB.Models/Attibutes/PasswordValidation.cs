namespace UserDB.Models.Attibutes
{
    using System;
    using System.ComponentModel.DataAnnotations;
    using System.Linq;
    using System.Reflection.Emit;

    [AttributeUsage(AttributeTargets.Property)]
    public class PasswordValidation : ValidationAttribute
    {
        private readonly int _passMinLen;
        private readonly int _passMaxLen;

        public PasswordValidation(int passwordMinLen = 6, int passwordMaxLen = 500)
        {
            this._passMinLen = passwordMinLen;
            this._passMaxLen = passwordMaxLen;
        }

        public bool ShouldContainLowerCase { get; set; }

        public bool ShouldContainUpperCase { get; set; }

        public bool ShouldContainDigit { get; set; }

        public bool ShouldContainSpecialSymbol { get; set; }

        public override bool IsValid(object value)
        {
            string passAsString = value as string;

            if (passAsString == null)
            {
                throw new ArgumentException("Property must be of type string.");
            }

            if (passAsString.Length < this._passMinLen |
                passAsString.Length > this._passMaxLen |
                this._passMinLen > this._passMaxLen)
            {
                return false;
            }

            if (this.ShouldContainUpperCase && !this.ContainsUpperCase(passAsString))
            {
                return false;
            }

            if (this.ShouldContainLowerCase && !this.ContainsLowerCase(passAsString))
            {
                return false;
            }

            if (this.ShouldContainDigit && !this.ContainsDigit(passAsString))
            {
                return false;
            }

            if (this.ShouldContainSpecialSymbol && !this.ContainsSpecialSymbol(passAsString))
            {
                return false;
            }

            return true;
        }

        private bool ContainsLowerCase(string passAsString)
        {
            foreach (char ch in passAsString)
            {
                if (char.IsLower(ch))
                {
                    return true;
                }
            }
            return false;
        }

        private bool ContainsUpperCase(string passAsString)
        {
            foreach (char ch in passAsString)
            {
                if (char.IsUpper(ch))
                {
                    return true;
                }
            }
            return false;
        }

        private bool ContainsDigit(string passAsString)
        {
            foreach (char ch in passAsString)
            {
                if (char.IsDigit(ch))
                {
                    return true;
                }
            }
            return false;
        }

        private bool ContainsSpecialSymbol(string passAsString)
        {
            char[] specialSymbols = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '<', '>', '?'};

            foreach (char ch in specialSymbols)
            {
                if (specialSymbols.Contains(ch))
                {
                    return true;
                }
            }
            return false;
        }

    }
}
