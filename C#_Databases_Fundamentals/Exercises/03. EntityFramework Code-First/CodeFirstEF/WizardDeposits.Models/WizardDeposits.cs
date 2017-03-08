using System;
using System.ComponentModel.DataAnnotations;

namespace WizardDeposits.Models
{
    public class WizardDeposits
    {
        private int age;
        private int magicWandSize;

        [Key]
        public int Id { get; set; }

        [MaxLength(50)]
        public string FirstName { get; set; }

        [MaxLength(60)]
        public string LastName { get; set; }

        [MaxLength(1000)]
        public string Notes { get; set; }

        [Required]
        public int Age
        {
            get { return this.age; }
            set
            {
                if (value >= 0)
                {
                    this.age = value;
                }
            }
        }

        [MaxLength(100)]
        public string MagicWandCreator { get; set; }

        public int MagicWandSize
        {
            get { return this.magicWandSize; }
            set
            {
                if (value >= 1)
                {
                    this.magicWandSize = value;
                }
            }
        }

        [MaxLength(20)]
        public string DepositGroup { get; set; }

        public DateTime DepositStartDate { get; set; }

        public decimal DepositAmount { get; set; }

        public decimal DepositInterest { get; set; }

        public decimal DepositCharge { get; set; }

        public DateTime DepositExpirationDate { get; set; }

        public bool IsDepositExpired { get; set; }
    }
}
