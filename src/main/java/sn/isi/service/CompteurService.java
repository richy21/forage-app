package sn.isi.service;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dao.ICompteurRepository;
import sn.isi.dto.Compteur;
import sn.isi.dao.exception.EntityNotFoundException;
import sn.isi.dao.exception.RequestException;
import sn.isi.mapping.CompteurMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CompteurService {

    private ICompteurRepository iCompteurRepository;
    private CompteurMapper compteurMapper;
    MessageSource messageSource;

    public CompteurService(ICompteurRepository iCompteurRepository, CompteurMapper compteurMapper, MessageSource messageSource){
        this.iCompteurRepository = iCompteurRepository;
        this.compteurMapper = compteurMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Compteur> getCompteur() {
        return StreamSupport.stream(iCompteurRepository.findAll().spliterator(), false)
                .map(compteurMapper::toCompteur)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Compteur getCompteur(int id) {
        return compteurMapper.toCompteur(iCompteurRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("compteur.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Compteur createCompteur(Compteur compteur) {
        return compteurMapper.toCompteur(iCompteurRepository.save(compteurMapper.fromCompteur(compteur)));
    }

    @Transactional
    public Compteur updateCompteur(int id, Compteur compteur) {
        return iCompteurRepository.findById(id)
                .map(entity -> {
                    compteur.setId(id);
                    return compteurMapper.toCompteur(
                            iCompteurRepository.save(compteurMapper.fromCompteur(compteur)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("compteur.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteCompteur(int id) {
        try {
            iCompteurRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("compteur.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
