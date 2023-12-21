<template>
    <v-card outlined>
        <v-card-title>
            DeleteFolder
        </v-card-title>

        <v-card-text>
            <String label="FolderId" v-model="value.folderId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteFolder"
            >
                DeleteFolder
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'DeleteFolderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.folderId = '';
        },
        watch: {
        },
        methods: {
            deleteFolder() {
                this.$emit('deleteFolder', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

