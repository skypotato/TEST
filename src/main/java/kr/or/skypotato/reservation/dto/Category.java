package kr.or.skypotato.reservation.dto;

public class Category {
	private int id;
	private String name;
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String categoryStr = "Category [id=${id},name=\"${name}\",count=${count}]";
		categoryStr = categoryStr.replaceAll("${id}",	""+id);
		categoryStr = categoryStr.replaceAll("${name}",	name);
		categoryStr = categoryStr.replaceAll("${count}",""+count);
		return categoryStr;
	}
}
