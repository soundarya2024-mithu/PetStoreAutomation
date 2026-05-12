package api.payload;

import java.util.List;

public class Pet {
	
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PetCatagory getCatagory() {
		return catagory;
	}
	public void setCatagory(PetCatagory catagory) {
		this.catagory = catagory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<PetTags> getTags() {
		return tags;
	}
	public void setTags(List<PetTags> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	PetCatagory catagory;
	String name;
	List<String> photoUrls;
	List<PetTags> tags;
	String status;

}
