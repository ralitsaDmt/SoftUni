namespace UserDB.Models.Attibutes
{
    using System;
    using System.ComponentModel.DataAnnotations;

    [AttributeUsage(AttributeTargets.Property)]
    public class TagAttribute : ValidationAttribute
    {
        public override bool IsValid(object value)
        {
            string passAsString = value as string;

            if (passAsString == null)
            {
                throw new ArgumentException("Property must be of type string.");
            }

            if (!passAsString.StartsWith("#"))
            {
                return false;
            }

            if (passAsString.Contains(" "))
            {
                return false;
            }

            if (passAsString.Length > 20)
            {
                return false;
            }

            return true;
        }
    }
}
