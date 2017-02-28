package gcursos.modelo;

import java.util.Date;

/**
 *
 * @author praveen
 */
public class Pessoa {
    
    private int id;
    private String primeiroNome;
    private String segundoNome;
    private String sobrenome;
    private Date dataNascimento;
    private Sexo sexo;
    private String telefoneFixo;
    private String telefoneMovicel;
    private String telefoneUnitel;
    private String email;
    private String facebook;
    private String foto;

    public Pessoa() {
    }

    public Pessoa(int id, String primeiroNome, String segundoNome, String sobrenome, Date dataNascimento, Sexo sexo, String telefoneFixo, String telefoneMovicel, String telefoneUnitel, String email, String facebook, String foto) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefoneFixo = telefoneFixo;
        this.telefoneMovicel = telefoneMovicel;
        this.telefoneUnitel = telefoneUnitel;
        this.email = email;
        this.facebook = facebook;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneMovicel() {
        return telefoneMovicel;
    }

    public void setTelefoneMovicel(String telefoneMovicel) {
        this.telefoneMovicel = telefoneMovicel;
    }

    public String getTelefoneUnitel() {
        return telefoneUnitel;
    }

    public void setTelefoneUnitel(String telefoneUnitel) {
        this.telefoneUnitel = telefoneUnitel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNomeCompeto() {
        return primeiroNome + " " + segundoNome + " " + sobrenome;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", primeiroNome=" + primeiroNome + ", segundoNome=" + segundoNome + ", sobrenome=" + sobrenome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", telefoneFixo=" + telefoneFixo + ", telefoneMovicel=" + telefoneMovicel + ", telefoneUnitel=" + telefoneUnitel + ", email=" + email + ", facebook=" + facebook + ", foto=" + foto + '}';
    }
    
}
