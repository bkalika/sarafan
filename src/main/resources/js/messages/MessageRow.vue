<template>
    <v-card class="my-2">
        <v-card-text primary-title>
             <i>({{ message.id }})</i>
            {{ message.text }}
        </v-card-text>
         <v-card-actions>
             <v-btn value="Edit" @click="edit" small flat round>Edit</v-btn>
<!--             <v-btn icon @click="del" small flat round>-->
             <v-btn @click="del" small flat round>
<!--                 <v-icon>bucket</v-icon>-->
                 Delete
             </v-btn>
         </v-card-actions>
     </v-card>
</template>

<script>
    import { mapActions } from 'vuex'

    export default {
        props: ['message', 'editMessage'],
        methods: {
            ...mapActions(['removeMessageAction']),
            edit() {
                this.editMessage(this.message)
            },
            del() {
                this.removeMessageAction(this.message)
            }
        }
    }
</script>

<style>

</style>