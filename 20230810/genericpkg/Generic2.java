package genericpkg;

public class Generic2<K, V> {
	K name;
	V id;
			
	void set(K name, V id) {
		this.name = name;
		this.id = id;
	}
	
	K getName() {
		return name;
	}
	
	V getId() {
		return id;
	}
}
