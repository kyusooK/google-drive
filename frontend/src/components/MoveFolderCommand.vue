<template>
    <v-card outlined>
        <v-card-title>
            MoveFolder
        </v-card-title>

        <v-card-text>
            <String label="FolderId" v-model="value.folderId" :editMode="editMode"/>
            <String label="DestinationFolderId" v-model="value.destinationFolderId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="moveFolder"
            >
                MoveFolder
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
        name: 'MoveFolderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.folderId = '';
            this.value.destinationFolderId = '';
        },
        watch: {
        },
        methods: {
            moveFolder() {
                this.$emit('moveFolder', this.value);
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

