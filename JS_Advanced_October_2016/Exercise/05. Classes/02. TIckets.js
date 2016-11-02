function storeTickets(ticketDescriptions, sortingCriteria) {
    class Ticket{
        constructor(destination, price, status){
            this.destination = destination;
            this.price = Number(price);
            this.status = status;
        }
    }

    let tickets = [];

    for (let ticket of ticketDescriptions){
        [name, price, status] = ticket.split('|');

        tickets.push(new Ticket(name, price, status));
    }

    if (sortingCriteria !== 'price'){
        tickets.sort((t1, t2) => t1[sortingCriteria].localeCompare(t2[sortingCriteria]));
    }
    else{
        tickets.sort((t1, t2) => t1[sortingCriteria] - t2[sortingCriteria]);
    }

    return tickets;
}


console.log(storeTickets(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'price'

));