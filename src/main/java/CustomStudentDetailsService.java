import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jiacheng.schoolweb.repositories.StudentRepository;

public class CustomStudentDetailsService implements UserDetailsService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public UserDetails loadUserByUsername(String eamil) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
