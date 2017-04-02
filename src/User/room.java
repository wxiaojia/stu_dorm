package User;

public class room {
	private int id,floor,bed,price,people,floor_id;
	public room(int id,int floor,int bed,int price,int people,int floor_id){
		super();
		this.id=id;
		this.floor=floor;
		this.bed=bed;
		this.price=price;
		this.people=people;
		this.floor_id=floor_id;
	}
	public room(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getFloor_id(){
		return floor_id;
	}
	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}

}
