<template>
  <div>
    <h2>Bibliothèque</h2>
    <form @submit.prevent="save">
      <div class="form-group">
        <label>nom du livre</label>
        <input type="text" v-model="livre.nom" class="form-control"  placeholder="nom">

      </div>
      <div class="form-group">
        <label>Auteur</label>
        <input type="text" v-model="livre.auteur_id" class="form-control"  placeholder="Auteur">

      </div>

      <div class="form-group">
        <label>editeur</label>
        <input type="text" v-model="livre.editeur_id" class="form-control"  placeholder="editeur">

      </div>

      <button type="submit" class="btn btn-primary">Save</button>
    </form>

    <h2>livre View</h2>
    <table class="table table-dark">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Nom du livre</th>
        <th scope="col">auteur</th>
        <th scope="col">editeur</th>
        <th scope="col">Option</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="livre in result" v-bind:key="livre.id">

        <td>{{ livre.livre_id }}</td>
        <td>{{ livre.nom }}</td>
        <td>{{ livre.auteur_id }}</td>
        <td>{{ livre.editeur_id }}</td>
        <td>
          <button type="button" class="btn btn-warning" @click="edit(livre)">Edit</button>
          <button type="button" class="btn btn-danger"  @click="remove(livre)">Delete</button>
        </td>
      </tr>

      </tbody>
    </table>

  </div>

</template>

<script>
import Vue from 'vue'
import axios from 'axios'

Vue.use(axios)

export default {
  name: 'livreCrud',
  data () {
    return {
      result: {},

      livre: {
        livre_id: '',
        nom: '',
        auteur_id: '',
        editeur_id: ''

      }
    }
  },
  created () {
    this.livreLoad()
  },
  mounted () {
    console.log('mounted() called.......')
  },

  methods: {
    livreLoad () {
      var page = 'http://localhost:8080/livre'
      axios.get(page)
        .then(
          ({data}) => {
            console.log(data)
            this.result = data
          }
        )
    },

    save () {
      if (this.livre.livre_id === '') {
        this.saveData()
      } else {
        this.updateData()
      }
    },
    saveData () {
      axios.post('http://localhost:8080/livre', this.livre)
        .then(
          ({data}) => {
            alert('saveddddd')
            this.livre.livre_id = ''
            this.livre.nom = ''
            this.livre.auteur_id = ''
            this.livre.editeur_id = ''
            this.livreLoad()
          }
        )
    },
    edit (livre) {
      this.livre = livre
    },
    updateData () {
      var editrecords = 'http://localhost:8080/livre'
      axios.put(editrecords, this.livre)
        .then(
          ({data}) => {
            this.livre.livre_id = ''
            this.livre.nom = ''
            this.livre.auteur_id = ''
            this.livre.editeur_id = ''
            alert('Updated!!!')
            this.livreLoad()
          }
        )
    },

    remove (livre) {
      var url = `http://localhost:8080/livre/delete/${livre.id}`
      axios.delete(url)
      alert('Deleteddd')
      this.livreLoad()
    }
  }
}
</script>
