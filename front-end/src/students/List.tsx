import { DeleteOutlined, EyeOutlined, PlusCircleOutlined } from "@ant-design/icons"
import { Button, Col, Input, Modal, Row, Space, Table, Tag } from "antd"
import studentService from "../services/StudentService";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom"



const List = () => {
    const [loading, setLoading] = useState(false);
    const [list, setList] = useState<any[]>([]);
    const [major, setMajor] = useState<string>("");

    const navigate = useNavigate();

    const loadData = async (major: string) => {
        setLoading(true);
        const data = await studentService.getAll(major);
        setList(data as unknown as any[])
        setLoading(false)

    }

    useEffect(() => {
        loadData(major)
    }, [major])



    const columns = [
        {
            title: "Id",
            dataIndex: "id"
        },
        {
            title: "First Name",
            dataIndex: "firstName"
        }
        ,
        {
            title: "lastName",
            dataIndex: "lastName"
        }
        ,
        {
            title: "email",
            dataIndex: "email"
        },
        {
            title: "Major",
            dataIndex: "major",
            render: (major: string) => <Tag color={major.length % 2 === 0 ? "blue" : "cyan"}>{major}</Tag>
        },
        {
            title: "Number of Courses",
            dataIndex: "coursesTaken",
            render: (coursesTaken: any[]) => coursesTaken.length
        },
        {
            title: "",
            dataIndex: "id",
            render: (id: any, record: any) => {
                return <Space><Button shape='circle' danger onClick={() => {
                    Modal.confirm({
                        title: "would you like to delete this item permenantly?",
                        onOk: async () => {
                            await studentService.delete(id);
                            await loadData("");
                        }
                    });
                }} icon={<DeleteOutlined />} />

                    <Button icon={<EyeOutlined />}
                        shape='circle'
                        onClick={() => {
                            navigate(`/details/${id}`, { state: record })

                        }} />


                </Space>;
            }
        }

    ]
    return <>
        <Row justify={"space-between"}>
            <Col>
                <Input.Search onSearch={(s) => setMajor(s)} />
            </Col>

            <Col>
                <Button loading={loading} onClick={() => {
                    navigate(`/details/`)

                }} icon={<PlusCircleOutlined />} >
                    Add Student

                </Button>
            </Col>
        </Row>

        <Table loading={loading} rowKey={"id"} columns={columns} dataSource={list} />


    </>
}

export default List;