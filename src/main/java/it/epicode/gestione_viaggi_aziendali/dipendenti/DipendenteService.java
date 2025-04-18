package it.epicode.gestione_viaggi_aziendali.dipendenti;

//@Service
//@Validated
//public class DipendenteService {
//    @Autowired
//    private DipendenteRepository dipendenteRepository;
//
//    public Dipendente createDipendente(DipendenteRequest request) {
//        Dipendente dipendente = new Dipendente();
//        BeanUtils.copyProperties(request, dipendente);
//        if (dipendenteRepository.existsByUsername(dipendente.getUsername())) {
//            throw new UsernameException("Username già in uso");
//        }
//        if (dipendenteRepository.existsByEmail(dipendente.getEmail())) {
//            throw new UsernameException("Email già in uso");
//        }
//        dipendente = dipendenteRepository.save(dipendente);
//        return dipendente;
//    }
//
//    public Page<Dipendente> findAll(Pageable pageable) {
//        return dipendenteRepository.findAll(pageable);
//    }
//
//    public Dipendente getDipendenteById(Long id) {
//        return dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException("Dipendente non trovato"));
//    }
//
//    public Dipendente updateDipendente(Long id, Dipendente dipendente) {
//        Dipendente existingDipendente = dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException("Dipendente non trovato"));
//        if (existingDipendente != null) {
//            existingDipendente.setNome(dipendente.getNome());
//            existingDipendente.setCognome(dipendente.getCognome());
//            existingDipendente.setEmail(dipendente.getEmail());
//            existingDipendente.setUsername(dipendente.getUsername());
//            return dipendenteRepository.save(existingDipendente);
//        }
//        return null;
//    }
//
//    public void deleteDipendente(Long id) {
//        dipendenteRepository.deleteById(id);
//    }
//
//    public boolean existsByUsername(String username) {
//        return dipendenteRepository.existsByUsername(username);
//    }
//}
