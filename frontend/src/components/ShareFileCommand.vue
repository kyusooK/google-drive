<template>
    <v-card outlined>
        <v-card-title>
            ShareFile
        </v-card-title>

        <v-card-text>
            <String label="FileId" v-model="value.fileId" :editMode="editMode"/>
            <String label="SharedWithEmail" v-model="value.sharedWithEmail" :editMode="editMode"/>
            <String label="Permission" v-model="value.permission" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="shareFile"
            >
                ShareFile
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
        name: 'ShareFileCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.fileId = '';
            this.value.sharedWithEmail = '';
            this.value.permission = '';
        },
        watch: {
        },
        methods: {
            shareFile() {
                this.$emit('shareFile', this.value);
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

