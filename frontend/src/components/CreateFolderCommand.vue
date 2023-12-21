<template>
    <v-card outlined>
        <v-card-title>
            CreateFolder
        </v-card-title>

        <v-card-text>
            <String label="FolderName" v-model="value.folderName" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createFolder"
            >
                CreateFolder
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
        name: 'CreateFolderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.folderName = '';
        },
        watch: {
        },
        methods: {
            createFolder() {
                this.$emit('createFolder', this.value);
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

