namespace Hotel.Data
{
    using System;
    using System.Data.Entity;
    using System.Linq;
    using Models;

    public class HotelContext : DbContext
    {
        public HotelContext()
            : base("name=HotelContext")
        {
        }

        public IDbSet<Employee> Employees { get; set; }

        public IDbSet<Customer> Customers { get; set; }

        public IDbSet<RoomStatus> RoomStatuses { get; set; }

        public IDbSet<RoomType> RoomTypes { get; set; }

        public IDbSet<BedType> BedTypes { get; set; }

        public IDbSet<Room> Rooms { get; set; }

        public Payment Payments { get; set; }

        public IDbSet<Occupancy> Occupancies { get; set; }
    }

    //public class MyEntity
    //{
    //    public int Id { get; set; }
    //    public string Name { get; set; }
    //}
}