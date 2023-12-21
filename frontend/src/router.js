
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import FileManagementFileManager from "./components/listers/FileManagementFileCards"
import FileManagementFileDetail from "./components/listers/FileManagementFileDetail"

import FolderManagementFolderManager from "./components/listers/FolderManagementFolderCards"
import FolderManagementFolderDetail from "./components/listers/FolderManagementFolderDetail"

import SearchEngineSearchManager from "./components/listers/SearchEngineSearchCards"
import SearchEngineSearchDetail from "./components/listers/SearchEngineSearchDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/fileManagements/files',
                name: 'FileManagementFileManager',
                component: FileManagementFileManager
            },
            {
                path: '/fileManagements/files/:id',
                name: 'FileManagementFileDetail',
                component: FileManagementFileDetail
            },

            {
                path: '/folderManagements/folders',
                name: 'FolderManagementFolderManager',
                component: FolderManagementFolderManager
            },
            {
                path: '/folderManagements/folders/:id',
                name: 'FolderManagementFolderDetail',
                component: FolderManagementFolderDetail
            },

            {
                path: '/searchEngines/searches',
                name: 'SearchEngineSearchManager',
                component: SearchEngineSearchManager
            },
            {
                path: '/searchEngines/searches/:id',
                name: 'SearchEngineSearchDetail',
                component: SearchEngineSearchDetail
            },



    ]
})
