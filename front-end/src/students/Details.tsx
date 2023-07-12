import { MinusCircleOutlined, PlusOutlined } from "@ant-design/icons";
import { Button, Col, Form, Input, Row, Space } from "antd";
import { useParams, useNavigate, useLocation } from "react-router-dom"
import studentService from "../services/StudentService";
import { useEffect } from "react";




const Details = () => {
    const [form] = Form.useForm();
    const { id } = useParams();
    const { state } = useLocation();
    const navigate = useNavigate();
    useEffect(() => {
        form.setFieldsValue(state);
    }, [])

    const submitForm = async () => {
        try {
            const values = await form.validateFields();
            console.log(values);


            if (id) {
                await studentService.update(parseInt(id), values);
            } else {
                await studentService.create(id);

            }
            form.resetFields();


        } catch (e) {

        }
    }

    console.log(id);

    return (
        <Form form={form} layout="vertical">

            <Row gutter={[16, 16]}>
                <Col span={12}>
                    <Form.Item label="First Name" rules={[{ required: true, message: 'first name is required' }]} name={"firstName"}>
                        <Input />
                    </Form.Item>
                </Col>

                <Col span={12}>
                    <Form.Item label="last Name" rules={[{ required: true, message: 'last name is required' }]} name={"lastName"}>
                        <Input />
                    </Form.Item>
                </Col>


                <Col span={12}>
                    <Form.Item label="email" rules={[{ required: true, message: 'email is required' }]} name={"email"}>
                        <Input type="email" />
                    </Form.Item>
                </Col>

                <Col span={12}>
                    <Form.Item label="Major" rules={[{ required: true, message: 'major is required' }]} name={"major"}>
                        <Input />
                    </Form.Item>
                </Col>

                <Col span={24}>
                    <Form.List name="coursesTaken">
                        {(fields, { add, remove }) => (
                            <>
                                {fields.map(({ key, name, ...restField }) => (
                                    <Space key={key} style={{ display: 'flex', marginBottom: 8 }} align="baseline">
                                        <Form.Item
                                            {...restField}
                                            name={[name, 'name']}
                                            rules={[{ required: true, message: 'Missing Course name' }]}
                                        >
                                            <Input placeholder="Course Name" />
                                        </Form.Item>
                                        <Form.Item
                                            {...restField}
                                            name={[name, 'code']}
                                            rules={[{ required: true, message: 'Missing course code' }]}
                                        >
                                            <Input placeholder="Course code" />
                                        </Form.Item>
                                        <MinusCircleOutlined onClick={() => remove(name)} />
                                    </Space>
                                ))}
                                <Form.Item>
                                    <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined />}>
                                        Add Course
                                    </Button>
                                </Form.Item>
                            </>
                        )}
                    </Form.List>
                </Col>
            </Row>

            <Row justify={"space-between"} >
                <Col span={8}>

                    <Button onClick={() => {
                        navigate("/")
                    }}> return to List</Button>
                </Col>

                <Col span={8}>

                    <Button onClick={submitForm}>Save</Button>
                </Col>

            </Row>
        </Form>
    )


}

export default Details;