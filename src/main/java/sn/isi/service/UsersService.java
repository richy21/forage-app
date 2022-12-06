package sn.isi.service;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dao.IUsersRepository;
import sn.isi.dto.Users;
import sn.isi.dao.exception.EntityNotFoundException;
import sn.isi.dao.exception.RequestException;
import sn.isi.mapping.UsersMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsersService {
    private IUsersRepository iUsersRepository;
    private UsersMapper usersMapper;
    MessageSource messageSource;

    public UsersService(IUsersRepository iUsersRepository, UsersMapper usersMapper, MessageSource messageSource){
        this.iUsersRepository = iUsersRepository;
        this.usersMapper = usersMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Users> getUsers() {
        return StreamSupport.stream(iUsersRepository.findAll().spliterator(), false)
                .map(usersMapper::toUsers)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Users getUsers(int id) {
        return usersMapper.toUsers(iUsersRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Users createUsers(Users users) {
        return usersMapper.toUsers(iUsersRepository.save(usersMapper.fromUsers(users)));
    }

    @Transactional
    public Users updateUsers(int id, Users user) {
        return iUsersRepository.findById(id)
                .map(entity -> {
                    user.setId(id);
                    return usersMapper.toUsers(
                            iUsersRepository.save(usersMapper.fromUsers(user)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteUsers(int id) {
        try {
            iUsersRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
