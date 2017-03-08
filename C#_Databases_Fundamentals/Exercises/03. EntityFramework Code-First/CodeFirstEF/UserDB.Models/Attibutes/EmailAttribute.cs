namespace UserDB.Models.Attibutes
{
    using System;
    using System.ComponentModel.DataAnnotations;
    using System.Text.RegularExpressions;

    [AttributeUsage(AttributeTargets.Property)]
    class EmailAttribute : ValidationAttribute
    {
        public override bool IsValid(object value)
        {
            string emailString = (string) value;
            if (emailString == null)
            {
                throw new ArgumentException("The email is not of type string.");
            }

            string regularExpression = @"([a-zA-Z0-9][a-zA-Z_\-.]*[a-zA-Z0-9])@([a-zA-Z-]+\.[a-zA-Z-]+(\.[a-zA-Z-]+)*)";
            Regex regex = new Regex(regularExpression);

            if (!regex.IsMatch(emailString))
            {
                return false;
            }
            return true;
        }
    }
}
