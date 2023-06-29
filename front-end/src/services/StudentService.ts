import fetch from "./FetchInspecor";

const studentService = {

    getAll: async (major: string) => {
        return await fetch.get(`/students?major=${major}`)
    },

    delete: async (id: number) => {
        await fetch.delete(`/students/${id}`)
    }

    ,

    create: async (student: any) => {
        await fetch.post(`/students`, student)
    },


    update: async (id: number, student: any) => {
        await fetch.put(`/students/${id}`, student)
    }
}


export default studentService;