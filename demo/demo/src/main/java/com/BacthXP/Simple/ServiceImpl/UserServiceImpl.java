package com.BacthXP.Simple.ServiceImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.BacthXP.Simple.Entity.RoleEntity;
import com.BacthXP.Simple.Entity.UserEntity;
import com.BacthXP.Simple.Pojo.UserDto;
import com.BacthXP.Simple.Repository.RoleRepository;
import com.BacthXP.Simple.Repository.UserRepository;
import com.BacthXP.Simple.Security.UserPrincipal;
import com.BacthXP.Simple.Service.UserService;
import com.BacthXP.Simple.SingleTone.ModelMapperSingleTone;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	RoleRepository roleRepository;

	private ModelMapper mapper = ModelMapperSingleTone.modelMapper();

	@Override
	public UserDto cteateUser(UserDto userDto) {

		userDto.setUserId(UUID.randomUUID().toString());
		userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

		UserEntity entity = mapper.map(userDto, UserEntity.class);

		Collection<RoleEntity> rolesEntity = new HashSet<>();
		for (String role : userDto.getRoles()) {
			RoleEntity roleEntity = roleRepository.findByName(role);
			if (roleEntity != null) {
				rolesEntity.add(roleEntity);
			}
		}
		entity.setRoles(rolesEntity);
		
		userRepository.save(entity);

		UserDto returnValue = mapper.map(entity, UserDto.class);

		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity entity = userRepository.findByEmail(email);
		if (entity == null)
			throw new UsernameNotFoundException("Email ID not found");

//		return new User(entity.getEmail(), entity.getEncryptedPassword()
//				,true, true, true, true, new ArrayList<>());

		return new UserPrincipal(entity);
	}

	@Override
	public UserDto getuserDetailsByEmail(String email) {
		UserEntity entity = userRepository.findByEmail(email);
		if (entity == null)
			throw new UsernameNotFoundException("Email ID not found");
		return mapper.map(entity, UserDto.class);
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		UserEntity entity = userRepository.findByUserId(userId);
		return mapper.map(entity, UserDto.class);
	}
     
	@Transactional
	@Override
	public boolean removeUserByUserId(String userId) {
		userRepository.deleteUserByUserId(userId);
		return true;
	}

}
