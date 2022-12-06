package sn.isi.service;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dao.IRolesRepository;
import sn.isi.dto.Roles;
import sn.isi.dao.exception.EntityNotFoundException;
import sn.isi.dao.exception.RequestException;
import sn.isi.mapping.RolesMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RolesServices {
    private IRolesRepository iRolesRepository;
    private RolesMapper rolesMapper;
    MessageSource messageSource;

    public RolesServices(IRolesRepository iRolesRepository, RolesMapper rolesMapper, MessageSource messageSource){
        this.iRolesRepository = iRolesRepository;
        this.rolesMapper = rolesMapper;
       this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Roles> getRoles() {
        return StreamSupport.stream(iRolesRepository.findAll().spliterator(), false)
                .map(rolesMapper::toRoles)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Roles getRoles(int id) {
        return rolesMapper.toRoles(iRolesRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Roles createRoles(Roles roles) {
        return rolesMapper.toRoles(iRolesRepository.save(rolesMapper.fromRoles(roles)));
    }

    @Transactional
    public Roles updateRoles(int id, Roles role) {
        return iRolesRepository.findById(id)
                .map(entity -> {
                    role.setId(id);
                    return rolesMapper.toRoles(
                            iRolesRepository.save(rolesMapper.fromRoles(role)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteRoles(int id) {
        try {
            iRolesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
