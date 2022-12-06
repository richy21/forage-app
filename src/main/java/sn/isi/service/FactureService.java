package sn.isi.service;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dao.IFactureRepository;
import sn.isi.dto.Facture;
import sn.isi.dao.exception.EntityNotFoundException;
import sn.isi.dao.exception.RequestException;
import sn.isi.mapping.FactureMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class FactureService {

    private IFactureRepository iFactureRepository;
    private FactureMapper factureMapper;
    MessageSource messageSource;

    public FactureService(IFactureRepository iFactureRepository, FactureMapper factureMapper, MessageSource messageSource){
        this.iFactureRepository = iFactureRepository;
        this.factureMapper = factureMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Facture> getFacture() {
        return StreamSupport.stream(iFactureRepository.findAll().spliterator(), false)
                .map(factureMapper::toFacture)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Facture getFacture(int id) {
        return factureMapper.toFacture(iFactureRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("facture.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public Facture createFacture(Facture facture) {
        return factureMapper.toFacture(iFactureRepository.save(factureMapper.fromFacture(facture)));
    }

    @Transactional
    public Facture updateFacture(int id, Facture facture) {
        return iFactureRepository.findById(id)
                .map(entity -> {
                    facture.setId(id);
                    return factureMapper.toFacture(
                            iFactureRepository.save(factureMapper.fromFacture(facture)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("facture.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteFacture(int id) {
        try {
            iFactureRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("facture.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
