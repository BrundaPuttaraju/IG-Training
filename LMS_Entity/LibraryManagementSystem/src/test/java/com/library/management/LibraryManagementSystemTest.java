package LMSTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.library.management.Entity.User;
import com.library.management.Service.UserService;
import com.library.management.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryManagementSystemTest {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void saveUserTest() {
		User user = new User(1, "USER", "bru@xyz.com", "Brunda", "Puttaraju", 1280166, "Bangalore", null);
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.saveUser(user));

	}

	@Test
	public void deleteUserTest() {
		User user = new User(1, "USER", "bru@xyz.com", "Brunda", "Puttaraju", 1280166, "Bangalore", null);
		service.deleteUser(1L);
		verify(repository, times(1)).delete(user);
	}

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new User(1,"USER", "bru@xyz.com", "Brunda", "Puttaraju", 1280166, "Bangalore", null) , 
						new User(2,"USER", "pal@xyz.com", "Pallavi", "Puttaraju", 1280154, "Chennai", null))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllUser().size());
				
	}
}
