<template>
    <v-card outlined>
        <v-card-title>
            ShareFolder
        </v-card-title>

        <v-card-text>
            <String label="FolderId" v-model="value.folderId" :editMode="editMode"/>
            <String label="SharedWithEmail" v-model="value.sharedWithEmail" :editMode="editMode"/>
            <String label="Permission" v-model="value.permission" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="shareFolder"
            >
                ShareFolder
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
        name: 'ShareFolderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.folderId = '';
            this.value.sharedWithEmail = '';
            this.value.permission = '';
        },
        watch: {
        },
        methods: {
            shareFolder() {
                this.$emit('shareFolder', this.value);
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

