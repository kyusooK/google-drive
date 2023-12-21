<template>
    <v-card outlined>
        <v-card-title>
            UploadFile
        </v-card-title>

        <v-card-text>
            <File offline label="File" v-model="value.file" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="uploadFile"
            >
                UploadFile
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
        name: 'UploadFileCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.file = {};
        },
        watch: {
        },
        methods: {
            uploadFile() {
                this.$emit('uploadFile', this.value);
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

