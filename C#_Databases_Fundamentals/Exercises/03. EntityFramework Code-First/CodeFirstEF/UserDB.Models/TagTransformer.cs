namespace UserDB.Models
{
    using System;
    using System.Linq;

    public static class TagTransformer
    {
        public static string Transform(object value)
        {
            string valAssString = (string) value;
            if (valAssString == null)
            {  
                throw new ArgumentException("Tag argument must be a string.");
            }

            string validTag = "";
            if (!valAssString.StartsWith("#"))
            {
                validTag = "#" + valAssString;
            }
            else
            {
                validTag = valAssString;
            }

            if (validTag.Contains(" "))
            {
                validTag = string.Join("", validTag
                    .Split(new string[] {" "}, StringSplitOptions.RemoveEmptyEntries));
            }

            if (validTag.Length > 20)
            {
                validTag = validTag.Substring(0, 20);
            }

            return validTag;
        }
    }
}
