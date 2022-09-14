package tw.leonchen.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	
//	?1 : 代表 下面String Name的第一個參數 （jpql）的寫法
//	annotation來定義
//	特別注意 這邊的 "name" 是JavaBean的寫法 
	@Query(value = "from Users where name like concat('%',?1,'%')")
	public List<Users> findUsers(String name);

	
//	這與上面的寫法相同, 同個結果 不同寫法
//	method name來定義
	public List<Users> findByNameLike(String name);
	
	@Query(value = "select * from Users", nativeQuery = true)
	public List<Users> findAll();
	
}
