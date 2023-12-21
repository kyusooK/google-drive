<template>
    <v-card outlined>
        <v-card-title>
            CreateNewFile
        </v-card-title>

        <v-card-text>
            <String label="FileName" v-model="value.fileName" :editMode="editMode"/>
            <String label="FileType" v-model="value.fileType" :editMode="editMode"/>
            <String label="FileContent" v-model="value.fileContent" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createNewFile"
            >
                CreateNewFile
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
        name: 'CreateNewFileCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.fileName = '';
            this.value.fileType = '';
            this.value.fileContent = '';
        },
        watch: {
        },
        methods: {
            createNewFile() {
                this.$emit('createNewFile', this.value);
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

