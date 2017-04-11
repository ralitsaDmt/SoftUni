package Problem_08_PetClinic;

public class Clinic {
    private String name;
    private int roomsCount;
    private Pet[] rooms;

    public Clinic(String name, int roomsCount){
        this.setName(name);
        this.setRooms(roomsCount);
        this.rooms = new Pet[roomsCount];
    }

    private void setName(String name){
        this.name = name;
    }

    private void setRooms(int roomsCount){

        if (roomsCount % 2 == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        }

        this.roomsCount = roomsCount;
    }

    public String getName() {
        return name;
    }


    public boolean addPet(Pet pet){

        if (pet == null) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        int startIndex = this.rooms.length / 2;

        if (this.rooms[startIndex] == null) {
            this.rooms[startIndex] = pet;
            return true;
        } else {
            int leftIndex = startIndex - 1;
            int rightIndex = startIndex + 1;
            while (leftIndex >= 0 && rightIndex <= this.rooms.length - 1) {
                if (this.rooms[leftIndex] == null) {
                    this.rooms[leftIndex] = pet;
                    return true;
                } else if (this.rooms[rightIndex] == null) {
                    this.rooms[rightIndex] = pet;
                    return true;
                }

                leftIndex--;
                rightIndex++;
            }
        }

        return false;
    }

    public boolean releasePet(){
        int startIndex = this.rooms.length / 2;

        if (this.rooms[startIndex] != null) {
            this.rooms[startIndex] = null;
            return true;
        } else if (rooms.length > 1) {
            int nextIndex = startIndex + 1;
            while (nextIndex != startIndex) {
                if (this.rooms[nextIndex] != null) {
                    this.rooms[nextIndex] = null;
                    return true;
                }

                if (nextIndex < this.rooms.length - 1) {
                    nextIndex++;
                } else {
                    nextIndex = 0;
                }
            }
        }
        return false;
    }

    public boolean hasEmptyRoom(){
        for (Pet room : rooms) {
            if (room == null) {
                return true;
            }
        }

        return false;
    }

    public String printRoomByIndex(int roomIndex){

        Pet pet = this.rooms[roomIndex];

        if (pet == null) {
            return "Room empty";
        } else {
            return pet.toString();
        }
    }

    public String printRooms(){

        int length = this.rooms.length;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append(printRoomByIndex(i));
            builder.append("\n");
        }

        String output = builder.substring(0, builder.length() - 1);

        return output;
    }
}




