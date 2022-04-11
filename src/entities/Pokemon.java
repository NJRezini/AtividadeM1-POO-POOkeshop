package entities;

public class Pokemon {

    private static int counter = 1;
    private Integer idPokemon;
    private String nickname;
    private Trainer trainer;
    private Species specie;
    private boolean deleted = false;

    public Pokemon(Species specie, String nickname, Trainer trainer) {
        this.idPokemon = counter;
        counter++;
        this.nickname = nickname;
        this.trainer = trainer;
        this.specie = specie;
    }

    public Integer getId() {
        return idPokemon;
    }

    public void setId(Integer id) {
        this.idPokemon = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void deletePokemon() {
        setDeleted(true);
    }

    public Species getSpecie() {
        return specie;
    }

    public void setSpecie(Species specie) {
        this.specie = specie;
    }

    @Override
    public String toString() {
        return "Pokemon (" + this.idPokemon + ") [Apelido: " + this.nickname + ", Espécie: " + this.getSpecie().getName() + "(" + this.getSpecie().getType1() + "|" + this.getSpecie().getType2() + "), Treinador: " + this.getTrainer().getName() + "]";
    }

}
