namespace Sale.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class StoreLocation
    {
        public StoreLocation()
        {
            this.SalesByLocation = new HashSet<Sale>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        public string LocationName { get; set; }

        public virtual ICollection<Sale> SalesByLocation { get; set; }
    }
}
